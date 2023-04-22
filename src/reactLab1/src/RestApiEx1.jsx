import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RestApiEx1 = () => {
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      
        const response = await axios.get(
            'https://api.publicapis.org/entries'
          );
          const booksData = response.data.entries;
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
            
            <strong>API:</strong> {entrie.API} <br />
            <strong>Description:</strong> {entrie.Description} <br />
            <strong>Auth:</strong> {entrie.Auth} <br />
            <strong>HTTPS:</strong> {entrie.HTTPS} <br />
            <strong>Cors:</strong> {entrie.Cors} <br />
            <strong>Link:</strong> {entrie.Link} <br />
            <strong>Category:</strong> {entrie.Category} <br />            
            </li>
        ))}
      </ul>
    )}
 </>
  );
};

export default RestApiEx1;
