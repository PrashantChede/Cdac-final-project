import axios from 'axios';
import { useState } from 'react';
import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';
// import { useEffect } from 'react/cjs/react.development';
import { useEffect } from 'react';
import categoryService from '../services/category.service';
import {PersonCircle,TextRight,Trash} from "react-bootstrap-icons";

const AddCategory = (props) => {
  const [categoryName, setCategoryName] = useState('');
  const [description, setDescription] = useState('');
  


  let [logoutFlag,setlogoutFlag]=useState(true);
  const win=window.sessionStorage;
  const seeLogout=()=>{
    console.log("inside logout");
    setlogoutFlag(true);
   }

   const logout=()=>{
    console.log("inside logout");
    navigate("/adminlogin");
    window.location.reload();
   }


  const navigate = useNavigate();
  const { id } = useParams();

  const saveCategory = (c) => {
    c.preventDefault();

    const category = {
      categoryName,
      description,
    };
    if (id) {
      //update
      categoryService
        .update(category)
        .then((response) => {
          console.log('Employee data updated successfully', response.data);
          // history.push('/');
        })
        .catch((error) => {
          alert(error.response.status);
          console.log('Error code ' + error);
          console.log('Something went wrong', error.response.data);
        });
    } else {
      //create
      categoryService
        .create(category)
        .then((response) => {
          console.log('employee added successfully', response.data);
        //  history.push('/category');
          navigate("/admincategory");
          // <Link to='/category'>Back to List</Link>
        })
        .catch((error) => {
          console.log('something went wroing' + error.response);
          navigate("/adminLoginAgain");
        });
    }
  };

  useEffect(() => {
    if (id) {
      categoryService
        .get(id)
        .then((category) => {
          setCategoryName(category.data.firstName);
          setDescription(category.data.lastName);
  
        })
        .catch((error) => {
          console.log('Something went wrong', error);
        });
    }
  }, []);
  return (

<div>
<div className='CustmerBody'>
      <div className='WelcomeBody'> <h1>Inside Admin Page</h1></div>
      <div className='ProfileBody'>
         <div className='profile' ><PersonCircle onClick={()=>seeLogout()}> </PersonCircle>{win.getItem('firstName')}</div>
         
{logoutFlag?<div className='align-items-end'>
  {/* <Link to='/customerlogin'>Logout</Link> */}
  <br></br>
  <button className='btn btn-danger ml-2' onClick={()=>logout()} > Logout </button>
        </div>:""}
      </div>
  </div>




    <div className='container'>
      {/* <div>......</div>
      <div>......</div>
      <div>......</div>
      <div>......</div> */}
      <hr/>
      <h3>Add Category</h3>
      
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='categoryName'
            value={categoryName}
            onChange={(c) => setCategoryName(c.target.value)}
            placeholder='Enter category name'
          />
        </div>
        <div><br></br></div>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='description'
            value={description}
            onChange={(c) => setDescription(c.target.value)}
            placeholder='Enter last name'
          />
        </div>
        <div><br></br></div>
        <div>
          <button onClick={(c) => saveCategory(c)} className='btn btn-primary'>
            Save Or Update
          </button>
          
        </div>

        
       </form>
       <hr />
       <Link to='/admincategory'>Back to List</Link>
     </div>
     </div>
  );
};

export default AddCategory;
