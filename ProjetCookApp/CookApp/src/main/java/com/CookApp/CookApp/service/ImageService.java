package com.CookApp.CookApp.service;

import com.CookApp.CookApp.Util.ImageUtil;
import com.CookApp.CookApp.bdd.Image;
import com.CookApp.CookApp.repository.ImageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Optional;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtil.compressImage(file.getBytes())).build());

        return "Image uploaded successfully: " +
                file.getOriginalFilename();

    }

    @Transactional
    public Image getInfoByImageByName(String name) {
        Optional<Image> dbImage = imageRepository.findByName(name);

        return Image.builder()
                .id(dbImage.get().getId())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtil.decompressImage(dbImage.get().getImage())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<Image> dbImage = imageRepository.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImage());
        return image;
    }

    @Transactional
    public String supprimer(Long id) {
        imageRepository.deleteById(id);
        return "Image Supprimé";
    }


}