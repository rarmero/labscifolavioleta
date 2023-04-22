import React, { useState, useEffect } from 'react';
import axios from 'axios';

const BookList2 = () => {
  const [books, setBooks] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchBooks = async () => {
      
        const response = await axios.get(
          'https://jsonplaceholder.typicode.com/posts?_limit=10'
        );
        const booksData = response.data;
        setBooks(booksData);
        setIsLoading(false);
    
    };
    fetchBooks();
  }, []);

  return (
    <>
    <h1>Books</h1>
      {isLoading ? (
        <p>Loading...</p>
      ) : (
        <ul>
      {books[0].title}
        </ul>
      )}
    </>
  );
};

export default BookList2;

