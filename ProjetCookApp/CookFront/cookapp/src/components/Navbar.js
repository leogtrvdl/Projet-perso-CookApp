import { useState, useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import "../styles/main.css";
import logo from '../img/logo.jpg';

function Navbar() {
    const navRef = useRef();
    const [isNavbarOpen, setIsNavbarOpen] = useState(false);

    const showNavbar = () => {
        setIsNavbarOpen(!isNavbarOpen);
    }

    return(
        <header className="bg-amber-200 grid grid-cols-6 min-h-16">
            <nav className="flex justify-between items-center w-[92%] mx-auto text-white col-start-1 col-end-2">
                <img className="w-32 min-w-32 min-h-auto" src={logo} alt="Logo"></img>
                <h1 className="text-3xl ml-5">CookApp</h1>
                <div className="flex items-center gap-6">
                    <button className="px-5 py-2 rounded-full cursor-pointer text-3xl md:invisible" onClick={showNavbar}>
                        {isNavbarOpen ? <FaTimes/> : <FaBars/>}
                    </button>
                    
                </div>
            </nav>
            <div ref={navRef} className={`navLinks col-start-3 col-end-7 bg-amber-200 text-white md:w-auto duration-1000 md:static absolute md:min-h-fit 
            min-h-[60vh] left-0 ${isNavbarOpen ? "top-[5.8%]" : "top-[-100%]"} w-full flex items-center px-5 justify-start`}>
                    <ul className="flex md:visible md:flex-row flex-col md:items-center md:gap-[6vw] md:text-3xl gap-28 text-4xl">
                        <li>
                            <a className="hover:text-gray-400" href="/accueil">Accueil</a>
                        </li>
                        <li>
                            <a className="hover:text-gray-400" href="/profil">Profil</a>
                        </li>
                        <li>
                            <a className="hover:text-gray-400" href="/recettes">Recettes</a>
                        </li>
                        <li className="md:absolute md:right-0 md:mr-10">
                            <a className="hover:text-gray-400" href="/profil">Login</a>
                        </li>
                    </ul>
            </div>
            
        </header>
    );
}

export default Navbar;