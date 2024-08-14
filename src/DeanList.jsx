import axios from 'axios';
import { useEffect, useState } from 'react';
import './DeanList.css'; // Make sure to create a corresponding CSS file for styling

const DeanList = () => {
  const [deans, setDeans] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchDeans = async () => {
      try {
        const response = await axios.get('http://localhost:8801/deanalone/show');
        console.log('Fetched data:', response.data); // Debugging line
        setDeans(response.data);
      } catch (err) {
        console.error("Error fetching deans:", err);
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    fetchDeans();
  }, []);

  const handleApproval = async (id, approvalStatus, action) => {
    try {
      await axios.put('http://localhost:8801/deanalone/update', null, {
        params: {
          id,
          approvalStatus
        }
      });

      // Debugging: Confirm that update request was successful
      console.log(`Updated item ${id}: ${approvalStatus}`);

      setDeans(prevDeans =>
        prevDeans.map(dean =>
          dean.id === id
            ? { ...dean, isApproved: approvalStatus, actionStatus: action }
            : dean
        )
      );
    } catch (err) {
      console.error("Error updating approval status:", err);
      setError(err);
    }
  };

  if (loading) return <p className="loading">Loading...</p>;
  if (error) return <p className="error">Error: {error.message}</p>;

  return (
    <div className="dean-list-container">
      <h1>Deans List</h1>
      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Application Type</th>
            <th>Location</th>
            <th>Reason</th>
            <th>Amount</th>
            <th>Approved</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {deans.map(dean => (
            <tr key={dean.id}>
              <td>{dean.id}</td>
              <td>{dean.applicationType}</td>
              <td>{dean.location}</td>
              <td>{dean.reason}</td>
              <td>{dean.amount}</td>
              <td>
                {dean.isApproved === 0
                  ? 'Pending'
                  : (dean.isApproved === 1 ? 'Yes' : 'No')}
              </td>
              <td>
                {dean.isApproved === 0 ? (
                  <>
                    <button onClick={() => handleApproval(dean.id, 1, 'Approved')}>Approve</button>
                    <button onClick={() => handleApproval(dean.id, -1, 'Rejected')}>Reject</button>
                  </>
                ) : (
                  <span>{dean.actionStatus || 'Action Done'}</span>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default DeanList;
