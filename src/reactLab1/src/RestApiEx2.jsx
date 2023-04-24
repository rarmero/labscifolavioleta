import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RestApiEx2 = () => {
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      
        const response = await axios.get(
            'https://api.github.com/repos/rarmero/labscifolavioleta/commits'
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
           <strong>url:</strong> {entrie.url} <br />
           <strong>author login:</strong> {entrie.commit.author.date} <br />
                    
            </li>
        ))}
       
      </ul>
    )}
 </>
  );
};

export default RestApiEx2;
