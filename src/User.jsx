// src/User.jsx
import axios from 'axios';
import { useState } from 'react';
import './User.css'; // Ensure this CSS file is created for styling

const User = () => {
  const [applicationType, setApplicationType] = useState('');
  const [submitTo, setSubmitTo] = useState('');
  const [formData, setFormData] = useState({
    reason: '',
    location: '',
    submittedFacultyName: '',
    facultyId: '',
    amount: 0
  });
  const [formVisible, setFormVisible] = useState(false);
  const [showSubmitTo, setShowSubmitTo] = useState(false);

  // Handler for when the application type is selected
  const handleApplicationTypeChange = (e) => {
    const type = e.target.value;
    setApplicationType(type);
    setShowSubmitTo(true); // Show the Submit To dropdown
  };

  // Handler for when the submitTo option is selected
  const handleSubmitToChange = (e) => {
    setSubmitTo(e.target.value);
  };

  // Handler for input changes in the form
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevData => ({
      ...prevData,
      [name]: value
    }));
  };

  // Handler for form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    let endpoint = '';

    // Determine the correct endpoint based on the submitTo option
    switch (submitTo) {
      case 'Principal':
        endpoint = 'http://localhost:8801/principal/add';
        break;
      case 'Management':
        endpoint = 'http://localhost:8801/management/add';
        break;
      case 'MTeam':
        endpoint = 'http://localhost:8801/mteam/add';
        break;
      default:
        alert('Please select a valid submission target');
        return;
    }

    try {
      // Include the application type in the request body
      await axios.post(endpoint, {
        ...formData,
        applicationType
      });
      alert('Application submitted successfully');
      setFormData({
        reason: '',
        location: '',
        submittedFacultyName: '',
        facultyId: '',
        amount: 0
      });
      setFormVisible(false);
      setApplicationType('');
      setSubmitTo('');
      setShowSubmitTo(false);
    } catch (err) {
      console.error('Error submitting application:', err);
      alert('Failed to submit application');
    }
  };

  return (
    <div className="user-container">
      <h1>Application Form</h1>
      {!formVisible ? (
        <>
          <div className="application-type">
            <label>Select Application Type:</label>
            <select onChange={handleApplicationTypeChange} value={applicationType}>
              <option value="">Select...</option>
              <option value="Maintenance">Maintenance</option>
              <option value="Damage">Damage</option>
              <option value="Consumable">Consumable</option>
              <option value="Construction">Construction</option>
            </select>
          </div>
          {showSubmitTo && (
            <div className="submit-to">
              <label>Select Submission Target:</label>
              <select onChange={handleSubmitToChange} value={submitTo}>
                <option value="">Select...</option>
                <option value="Principal">Principal</option>
                <option value="Management">Management</option>
                <option value="MTeam">MTeam</option>
              </select>
              <button onClick={() => setFormVisible(true)}>Next</button>
            </div>
          )}
        </>
      ) : (
        <form onSubmit={handleSubmit} className="application-form">
          <div className="form-group">
            <label htmlFor="reason">Reason:</label>
            <input
              type="text"
              id="reason"
              name="reason"
              value={formData.reason}
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="location">Location:</label>
            <input
              type="text"
              id="location"
              name="location"
              value={formData.location}
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="submittedFacultyName">Submitted Faculty Name:</label>
            <input
              type="text"
              id="submittedFacultyName"
              name="submittedFacultyName"
              value={formData.submittedFacultyName}
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="facultyId">Faculty ID:</label>
            <input
              type="text"
              id="facultyId"
              name="facultyId"
              value={formData.facultyId}
              onChange={handleInputChange}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="amount">Amount:</label>
            <input
              type="number"
              id="amount"
              name="amount"
              value={formData.amount}
              onChange={handleInputChange}
              required
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      )}
    </div>
  );
};

export default User;
