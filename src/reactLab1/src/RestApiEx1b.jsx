import React, { useState, useEffect } from 'react';
import axios from 'axios';

  
const RestApiEx1b = () => {
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [index, setIndex] = useState(0);


  function handleClick() {
    setIndex(index + 1);
  }

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


  let book = posts[index];

  return (
 <>
    <h1>Entries</h1>
    {isLoading ? (
      <p>Loading...</p>
    ) : (
<div>
     
     <h2>
     <i>{book.API} </i> 
     by {book.Description}
   </h2>
   <h3>  
     ({index + 1} of {posts.length})
   </h3>
   <p>
     src={book.Link} 
     alt={book.Category}
   </p>
   <button onClick={handleClick}>
      Next
    </button>
</div>
    )}
 </>
  );
};

export default RestApiEx1b;
