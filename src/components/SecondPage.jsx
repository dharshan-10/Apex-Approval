import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './SecondPage.css'; // Import the CSS file

const SecondPage = () => {
    const navigate = useNavigate();
    const [selectedType, setSelectedType] = useState('');

    const handleTypeSelection = (type) => {
        setSelectedType(type);
        switch(type) {
            case 'Type1':
                navigate('/Maintenance');
                break;
            case 'Type2':
                navigate('/Consumable');
                break;
            case 'Type3':
                navigate('/Event');
                break;
            case 'Type4':
                navigate('/Damage');
                break;
            case 'Type5':
                navigate('/BuyNewProduct');
                break;
            default:
                break;
        }
    };

    return (
        <div className="container">
            <h2>Select a Type:</h2>
            <div className="radio-group">
                <div className="radio-item">
                    <input
                        type="radio"
                        id="type1"
                        name="type"
                        value="Type1"
                        checked={selectedType === 'Type1'}
                        onChange={() => handleTypeSelection('Type1')}
                    />
                    <label htmlFor="type1">Maintenance</label>
                </div>
                
                <div className="radio-item">
                    <input
                        type="radio"
                        id="type2"
                        name="type"
                        value="Type2"
                        checked={selectedType === 'Type2'}
                        onChange={() => handleTypeSelection('Type2')}
                    />
                    <label htmlFor="type2">Consumable</label>
                </div>
                
                <div className="radio-item">
                    <input
                        type="radio"
                        id="type3"
                        name="type"
                        value="Type3"
                        checked={selectedType === 'Type3'}
                        onChange={() => handleTypeSelection('Type3')}
                    />
                    <label htmlFor="type3">Event</label>
                </div>
                
                <div className="radio-item">
                    <input
                        type="radio"
                        id="type4"
                        name="type"
                        value="Type4"
                        checked={selectedType === 'Type4'}
                        onChange={() => handleTypeSelection('Type4')}
                    />
                    <label htmlFor="type4">Damage</label>
                </div>
                
                <div className="radio-item">
                    <input
                        type="radio"
                        id="type5"
                        name="type"
                        value="Type5"
                        checked={selectedType === 'Type5'}
                        onChange={() => handleTypeSelection('Type5')}
                    />
                    <label htmlFor="type5">Buy New Products</label>
                </div>
            </div>
        </div>
    );
};

export default SecondPage;
