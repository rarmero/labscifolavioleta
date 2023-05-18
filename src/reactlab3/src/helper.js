
 export function getDate(){
    var today = new Date();
    
    return today.toISOString().slice(0,10);
    
    }
  
  
    export function getDateDue(){
      var today = new Date();
      today.setDate(today.getDate()+10);
      return today.toISOString().slice(0,10);
      }