import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RestApiEx3 = () => {
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

    <p>
     {posts[0].commit.author.date}        
     </p> 

    )
   }
 </>
  );
};

export default RestApiEx3;
