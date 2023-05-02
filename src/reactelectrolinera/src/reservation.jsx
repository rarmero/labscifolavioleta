import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import axios from 'axios';
import Pagination from '@mui/material/Pagination';
import usePagination from './Pagination'

const Reservation = () => {

  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [pageNumber, setPageNumber]= useState(1)
  const [postNumber]= useState(5)

  const currentPageNumber = (pageNumber * postNumber) - postNumber  
  const paginatedPosts = posts.splice(currentPageNumber, postNumber)

    const handlePrev =()=>{
        if(pageNumber === 1) return
        setPageNumber(pageNumber - 1)
    }
    const handleNext =()=>{
        setPageNumber(pageNumber + 1)
    }

  useEffect(() => {
          
            fetch('http://localhost:8090/api/reservations')
            .then(res => res.json())
            .then(data=>{
                setPosts(data)
            }) 
   
  })

  return (
        <div>
            <h2>Posts</h2>
            {paginatedPosts.map((post)=>(
                <div>
                    <h2>{post.dateStart} </h2>
                    <p>{post.dateStart} </p>
                </div>
            ))}
            <div>Page {pageNumber} </div>
            <div>
                <button onClick={handlePrev} >prev</button>
                <button onClick={handleNext}>next</button>
            </div>
        </div>
  );
};

export default Reservation;
