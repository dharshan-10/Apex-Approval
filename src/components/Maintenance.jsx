// Maintenance.js

import { useState } from 'react';
import './Maintenance.css'; // Import CSS file

const Maintenance = () => {
    const initialFormData = {
        area: '',
        works: '',
        totalAmount: '',
        submitTo: '',
        type: ''
    };

    const [formData, setFormData] = useState(initialFormData);

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        formData.type = "Maintenance";
        try {
            const response = await fetch("http://localhost:8801/user/Maintenance/insert", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                console.log("Submitted the application successfully");
                setFormData(initialFormData);
            } else {
                console.log("Error while submitting the form");
            }
        } catch (error) {
            console.error("Error while submitting the Form:", error);
        }
    };

    return (
        <div className='container'>
            <div className='form'>
                <label htmlFor="area">Enter the maintenance area:</label>
                <input
                    type="text"
                    id="area"
                    name="area"
                    value={formData.area}
                    onChange={handleChange}
                />
            </div>
            <div className='form'>
                <label htmlFor="works">Works to be done:</label>
                <textarea
                    id="works"
                    name="works"
                    value={formData.works}
                    onChange={handleChange}
                />
            </div>
            <div className='form'>
                <label htmlFor="totalAmount">Total amount:</label>
                <input
                    type="text"
                    id="totalAmount"
                    name="totalAmount"
                    value={formData.totalAmount}
                    onChange={handleChange}
                />
            </div>
            <div className='form'>
                <label htmlFor="submitTo">Submit form to:</label>
                <select
                    id="submitTo"
                    name="submitTo"
                    value={formData.submitTo}
                    onChange={handleChange}
                >
                    <option value="">Select the person to submit the form</option>
                    <option value="Dean">Dean</option>
                    <option value="Principal">Principal</option>
                    <option value="MTeam">Maintenance Team</option>
                </select>
            </div>
            <button className='button' onClick={handleSubmit}>Submit</button>
        </div>
    );
};

export default Maintenance;
