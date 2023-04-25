import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Reservation = () => {
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      
        const response = await axios.get(
            'http://localhost:8090/api/reservations',{timeout:6000}
          );
          const booksData = response.data;
          setPosts(booksData);
          setIsLoading(false);
    
    };
    fetchData();
  }, []);

  return (
 <>
    <h1>Entries</h1>
    {isLoading ? (
      <p>Loading...</p>
    ) : (

      <ul>      
        {posts.map((entrie) => (
          <li >            
          
          
            <strong>Date Start:</strong> {entrie.dateStart} <br />          
            <strong>Date End:</strong> {entrie.dateEnd} <br />          
          
            </li>
        ))}
      </ul>
    )}
 </>
  );
};

export default Reservation;
