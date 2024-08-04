import { useNavigate } from "react-router-dom";

export default function HOD(){
    const navigate=useNavigate();
    function handleOnClick(){
        navigate('/');
    }
    return<div>
         in HOD page
         <button onClick={handleOnClick}>Back</button>
    </div>
}