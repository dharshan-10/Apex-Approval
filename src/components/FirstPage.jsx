import { Link } from 'react-router-dom';

function FirstPage() {
  return (
    <div>
      Welcome to Apex Approval Form
      <ul>
        <li><Link to='/login'>Login</Link></li>
      </ul>
    </div>
  );
}

export default FirstPage;
