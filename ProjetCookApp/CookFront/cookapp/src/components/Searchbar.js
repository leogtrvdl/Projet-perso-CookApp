import { useEffect, useRef, useState } from "react";
import axios from 'axios';


function Searchbar() {

    const [data, setData] = useState([]);
    const [recettes, setRecettes] = useState([]);
    const [isSearchOpen, setIsSearchOpen] = useState(false);

    const searchResult = useRef();

    useEffect(() => {
        axios.get('http://localhost:8080/recettes/read')
        .then(res=> {
            setData(res.data)
            setRecettes(res.data);
        })
        .catch(err => console.log(err));
    }, [])

    const Filter = (event) => {
        setRecettes(data.filter(f => f.nom.toLowerCase().includes(event.target.value)));
    }

    const rechercheBar = () => {
        setIsSearchOpen(!isSearchOpen);
    }

    return (
        <div className="bg-yellow-200">
            <div className="mr-28">
                <div className="flex items-center justify-center bg-yellow-100">
                    <input type="text" className="form-control" onFocus={rechercheBar} onChange={Filter} placeholder="            Recherche" />
                </div>
                <div ref={searchResult} className={`bg-yellow-100 ${isSearchOpen ? "top-auto" : "top-[-100%]"} duration-1000 gap-28 w-full absolute top-[-100%] justify-center flex 
                items-center `}>
                    <div>
                        {recettes.map((d, i) => (
                            <div key={i}>
                                <div>{d.nom}</div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    );

}

export default Searchbar;