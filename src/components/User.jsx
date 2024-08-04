import { useState } from "react";

function User() {
  const [application, setApplication] = useState({
    applicationType: "",
    applicationReason: "",
    applicationAmount: 0,
  });

  function handleChange(e) {
    setApplication({
      ...application,
      [e.target.name]: e.target.value,
    });
  }

  async function handleSubmit(e) {
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:8801/user/insert", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(application),
      });

      if (response.ok) {
        setApplication({ applicationType: "", applicationReason: "", applicationAmount: 0 });
        console.log("Approval request submitted successfully");
      } else {
        console.error("Error submitting approval request");
      }
    } catch (error) {
      console.error("Error submitting approval request:", error);
    }
  }

  return (
    <>
      <form onSubmit={handleSubmit}>
        <label>
          Select the Type of Application
          <br />
          <select
            name="applicationType"
            value={application.applicationType}
            onChange={handleChange}
          >
            <option value="">Select Type of Application</option>
            <option value="Maintenance">Maintenance</option>
            <option value="Consumable">Consumable</option>
            <option value="Damage">Damage</option>
            <option value="Event">Event</option>
          </select>
        </label>
        <br />
        <label>
          Enter the Reason
          <br />
          <textarea
            name="applicationReason"
            value={application.applicationReason}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Enter the Amount
          <br />
          <input
            name="applicationAmount"
            value={application.applicationAmount}
            type="number"
            onChange={handleChange}
          />
        </label>
        <button type="submit">Submit</button>
      </form>
    </>
  );
}

export default User;