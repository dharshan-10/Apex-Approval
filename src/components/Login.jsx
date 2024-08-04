import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const navigate = useNavigate();
  const [user, setUser] = useState({
    username: "",
    password: "",
    usertype: ""
  });

  function handleChange(e) {
    setUser({
      ...user,
      [e.target.name]: e.target.value
    });
  }

  function handleBack() {
    navigate('/');
  }
  const [isFormValid, setIsFormValid] = useState(false);

  useEffect(() => {
    // Check if all fields are filled
    const { username, password, usertype } = user;
    setIsFormValid(username && password && usertype);
  }, [user]);
  function handleSubmitClick() {
    if(!isFormValid){
      alert("Fill all the Fields");
      return ;
    }
    fetch("http://localhost:8801/user/check", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(user)
    })
    .then((response) => response.text()) // Parsing response as text
    .then((text) => {
      if (text === 'false') {
        console.log("redirecting to firstpage");
        navigate('/');
      } else if (text === 'true') {
        switch (user.usertype){
          case 'HOD':
            navigate('/hod');
            break;
            case 'MTeam':
              navigate('/mteam');
              break;
              case 'Dean':
                navigate('/dean');
                break;
        }
        // Navigate to another page or perform further actions for successful login
      } else {
        throw new Error('Unexpected response from server');
      }
    })
    .catch((err) => {
      console.error("Error:", err.message);
    });
  }

  return (
    <>
      <form>
        <label>
          Enter your UserName<br />
          <input
            onChange={handleChange}
            type="text"
            name="username"
            value={user.username}
          /><br />
        </label>
        <label>
          Enter your Password<br />
          <input
            onChange={handleChange}
            type="text"
            name="password"
            value={user.password}
          /><br />
        </label>
        <label>
          Select User Type<br />
          <select name="usertype" value={user.usertype} onChange={handleChange}>
            <option value="">Select Type of User</option>
            <option value="HOD">HOD</option>
            <option value="MTeam">MTeam</option>
            <option value="Dean">Dean</option>
          </select>
        </label>
      </form>
      <button onClick={handleSubmitClick} type="button">Login</button>
      <button onClick={handleBack} type="button">Back</button>
    </>
  );
}
