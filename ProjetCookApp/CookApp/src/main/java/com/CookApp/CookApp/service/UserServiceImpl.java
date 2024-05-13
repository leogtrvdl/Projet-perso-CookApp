package com.CookApp.CookApp.service;

import com.CookApp.CookApp.bdd.User;
import com.CookApp.CookApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public User creer(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }

    @Override
    public User modifier(Long id, User user) {
        return userRepository.findById(id)
                .map(u-> {
                    u.setNom(user.getNom());
                    u.setMdp(user.getMdp());
                    u.setEmail(user.getEmail());
                    return userRepository.save(u);
                }).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        userRepository.deleteById(id);
        return "Produit supprimer!";
    }
}
