import React, { useState, useEffect } from 'react';
import axios from 'axios';

const RestApiEx3 = ({userRepo,repository,url}) => {
  const [posts, setPosts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      
        const response = await axios.get(
          url 
          );
          const booksData = response.data;
          setPosts(booksData);
          setIsLoading(false);
    
    };
    fetchData();
  }, [userRepo,repository,url]);

  return (
 <>
   
    {isLoading ? (
      <p>Loading...</p>
    ) : (

    <table>
    <tr>
      <td>{getDate}</td>
     <td><strong>User:</strong></td>
     <td>{userRepo} </td>
     <td><strong>Repo:</strong></td>
     <td>{repository} </td> 
     <td> <strong>Result check date:</strong></td>
      <td> {
      checkDate (posts[0].commit.author.date) 
     }
     </td>
     { getIcon (posts[0].commit.author.date) }
     <td>
     </td>
     </tr>

     </table>       

    )
   }

 </>
  );
};


function getDate(){
 return new Date().toLocaleString('es-ES');
}

function checkDate(dateRepoParam) {
  let dateRepo = new Date(dateRepoParam);
  let today = new Date()

 
  if (dateRepo.getMonth() === today.getMonth()){ 

  if (dateRepo.getDate() < (today.getDate() - 5)) 
  {  
    return(`${dateRepo.toLocaleString('es-ES')}, is more than 5 days`);

  } else if (dateRepo.getDate() < (today.getDate() - 10)) {
    
    return(`${dateRepo.toLocaleString('es-ES')}, is more than 10 days`);
  }  else { 
    return (`Congrats, ${dateRepo.toLocaleString('es-ES')}, is correct` );
} 

  }
  else return (`Consider update the repository, ${dateRepo.toLocaleString('es-ES')}, is very late`);

};

function getIcon(dateRepoParam) {
  let dateRepo = new Date(dateRepoParam);
  let today = new Date()

 
  if (dateRepo.getMonth() === today.getMonth()){ 

  if (dateRepo.getDate() < (today.getDate() - 5)) 
  {  
    return(<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-square" viewBox="0 0 16 16">
    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
    <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
  </svg>);

  } else if (dateRepo.getDate() < (today.getDate() - 10)) {
    
    return(<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-exclamation-square-fill" viewBox="0 0 16 16">
    <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6 4c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995A.905.905 0 0 1 8 4zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </svg>);

  }  else { 
    return (
       <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-heart-eyes" viewBox="0 0 16 16"><path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/><path d="M11.315 10.014a.5.5 0 0 1 .548.736A4.498 4.498 0 0 1 7.965 13a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .548-.736h.005l.017.005.067.015.252.055c.215.046.515.108.857.169.693.124 1.522.242 2.152.242.63 0 1.46-.118 2.152-.242a26.58 26.58 0 0 0 1.109-.224l.067-.015.017-.004.005-.002zM4.756 4.566c.763-1.424 4.02-.12.952 3.434-4.496-1.596-2.35-4.298-.952-3.434zm6.488 0c1.398-.864 3.544 1.838-.952 3.434-3.067-3.554.19-4.858.952-3.434z"/></svg>
    
    )
} 

  }
  else return (<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-exclamation-octagon-fill" viewBox="0 0 16 16">
  <path d="M11.46.146A.5.5 0 0 0 11.107 0H4.893a.5.5 0 0 0-.353.146L.146 4.54A.5.5 0 0 0 0 4.893v6.214a.5.5 0 0 0 .146.353l4.394 4.394a.5.5 0 0 0 .353.146h6.214a.5.5 0 0 0 .353-.146l4.394-4.394a.5.5 0 0 0 .146-.353V4.893a.5.5 0 0 0-.146-.353L11.46.146zM8 4c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995A.905.905 0 0 1 8 4zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
</svg>);

};

export default RestApiEx3;
