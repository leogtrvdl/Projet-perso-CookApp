//import de lib
import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

//pages
import Accueil from './pages/Accueil';
import Recettes from './pages/Recettes';
import Profil from './pages/Profil';
import Nopage from './pages/Nopage';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route index element={<Accueil/>} />
                <Route path="/accueil" element={<Accueil/>}/>
                <Route path="/recettes" element={<Recettes/>}/>
                <Route path="/profil" element={<Profil/>}/>

                <Route path="*" element={<Nopage/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;