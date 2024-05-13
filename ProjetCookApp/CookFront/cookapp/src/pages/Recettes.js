import Navbar from '../components/Navbar'
import Carousel from '../components/Carousel';
import { imagesTest } from '../components/imagesTest';


function Recettes() {

    const images = imagesTest;

    return(
        <div className='bg-yellow-100'>
            <div className=''>
                <Navbar/>
            </div>
            <div className='md:visible max-md:invisible grid md:grid-cols-3 min-h-64'>
                <Carousel/>
            </div>
        </div>
    );
}

export default Recettes;