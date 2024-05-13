import Slider from "react-slick";
import { useState } from "react";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import axios from "axios";
import image1 from "../img/logo.jpg";
import image2 from "../img/shrek2.jpg";
import image3 from "../img/shrek3.jpg";
import image4 from "../img/shrek4.jpg";

function Carousel(recettes) {

    const [recettesData, setRecettesData] = useState([]);

    const carouselSettings = {
        infinite: true,
        speed: 500,
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        arrows: false,
      };

    const fetchRecettesData = async () => {
        try {
          const response = await axios.get(recettes);
          setRecettesData(response.data);
        } catch (error) {
        }
    };
    fetchRecettesData();

    return(
        <div className="col-start-2 max-w-[500px] mt-20 static">
            <Slider {...carouselSettings} className="min-h-full w-full h-auto">
                <div>
                    <img src={image1} className="min-size-40 size-40 rounded-3xl object-cover"/>
                </div>
                <div>
                    <img src={image2} className="min-size-40 size-40 rounded-3xl object-cover"/>
                </div>
                <div>
                    <img src={image3} className="min-size-40 size-40 rounded-3xl object-cover"/>
                </div>
                <div>
                    <img src={image4} className="min-size-40 size-40 rounded-3xl object-cover"/>
                </div> 
            </Slider>
        </div>
    )
}

export default Carousel