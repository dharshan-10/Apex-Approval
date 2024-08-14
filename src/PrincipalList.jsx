import axios from 'axios';
import { useEffect, useState } from 'react';
import './PrincipalList.css';

const PrincipalList = () => {
  const [principals, setPrincipals] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchPrincipals = async () => {
      try {
        const response = await axios.get('http://localhost:8801/principalalone/show');
        console.log('Fetched data:', response.data); // Debugging line
        setPrincipals(response.data);
      } catch (err) {
        console.error("Error fetching principals:", err);
        setError(err);
      } finally {
        setLoading(false);
      }
    };

    fetchPrincipals();
  }, []);

  const handleApproval = async (id, approvalStatus, action) => {
    try {
      await axios.put('http://localhost:8801/principalalone/update', null, {
        params: {
          id,
          approvalStatus
        }
      });

      // Debugging: Confirm that update request was successful
      console.log(`Updated item ${id}: ${approvalStatus}`);

      setPrincipals(prevPrincipals =>
        prevPrincipals.map(principal =>
          principal.id === id
            ? { ...principal, isApproved: approvalStatus, actionStatus: action }
            : principal
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
    <div className="principal-list-container">
      <h1>Principals List</h1>
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
          {principals.map(principal => (
            <tr key={principal.id}>
              <td>{principal.id}</td>
              <td>{principal.applicationType}</td>
              <td>{principal.location}</td>
              <td>{principal.reason}</td>
              <td>{principal.amount}</td>
              <td>
                {principal.isApproved === 0
                  ? 'Pending'
                  : (principal.isApproved === 1 ? 'Yes' : 'No')}
              </td>
              <td>
                {principal.isApproved === 0 ? (
                  <>
                    <button onClick={() => handleApproval(principal.id, 1, 'Approved')}>Approve</button>
                    <button onClick={() => handleApproval(principal.id, -1, 'Rejected')}>Reject</button>
                  </>
                ) : (
                  <span>{principal.actionStatus || 'Action Done'}</span>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PrincipalList;
