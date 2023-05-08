
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./Home.jsx";
import BookList from './BookList';
import BookList2 from './BookList2';
import RestApiEx1 from './RestApiEx1';
import RestApiEx2 from './RestApiEx2';
import RestApiEx3 from './RestApiEx3';
import RestApiEx4 from './RestApiEx4';
import RestApiEx1b from './RestApiEx1b'
import Layout from './route/Layout';
import NoPage from "./route/NoPage";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="BookList1" element={<BookList />} />
          <Route path="BookList2" element={<BookList2 />} />
          <Route path="RestApiEx1" element={<RestApiEx1 />} />
          <Route path="RestApiEx2" element={<RestApiEx2 />} />
          <Route path="RestApiEx3" element={<RestApiEx3 />} />
          <Route path="RestApiEx4" element={<RestApiEx4 />} />
          <Route path="*" element={<NoPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}



export default App;
