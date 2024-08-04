import { BrowserRouter, Route, Routes } from 'react-router-dom';
import BuyNewProduct from './components/BuyNewProduct';
import Consumable from './components/Consumable';
import Damage from './components/Damage';
import Dean from './components/Dean';
import Event from './components/Event';
import FirstPage from './components/FirstPage';
import Login from './components/Login';
import Maintenance from './components/Maintenance';
import Mteam from './components/Mteam';
import SecondPage from './components/SecondPage';
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<FirstPage />} />
        <Route path='/login' element={<Login />} />
        <Route path='/hod' element={<SecondPage/>} />
        <Route path='/Mteam' element={<Mteam />} />
        <Route path='/dean' element={<Dean />} />
        <Route path='/Maintenance' element={<Maintenance/>} />
        <Route path='/Consumable' element={<Consumable/>} />
        <Route path='/Event' element={<Event/>} />
        <Route path='/Damage' element={<Damage/>} />
        <Route path='/BuyNewProduct' element={<BuyNewProduct/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
