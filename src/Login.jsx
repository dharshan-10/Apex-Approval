// src/Login.js
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';
const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
const navigate=useNavigate();
  const handleLogin = (event) => {
    event.preventDefault();
    // Check the credentials
    if (username === 'principal@gmail.com' && password === 'principal') {
        navigate('/principal');
    }
    else if (username === 'dean@gmail.com' && password === 'dean') {
        navigate('/dean');
    } 
    else if (username === 'mteam@gmail.com' && password === 'mteam') {
        navigate('/mteam');
    } else if (username === 'user1@gmail.com' && password === 'user1') {
        navigate('/user');
    }else if (username === 'management@gmail.com' && password === 'management') {
        navigate('/management');
    }  
    else {
      console.log('Invalid credentials');
    }
    setPassword('');
    setUsername('');
  };

  return (
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <div className="form-group">
          <label htmlFor="username">Username</label>
          <input
            type="email"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
