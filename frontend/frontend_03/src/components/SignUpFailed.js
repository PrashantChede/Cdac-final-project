import { Link } from 'react-router-dom';
import { useState } from 'react';
import adminService from '../services/admin.service ';
// import { Navigate } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


const SignUpFailed = (props) => {
 

    return (
        <>
            <div>.....</div>
            <div>.....</div>
            <div>.....</div>
            <div>.....</div>
           
        <h1>Failed to Register </h1>
        

        <Link to='/signup' className='btn btn-primary mb-2'>
        <h2>click here to register</h2>
          </Link>

        </>
    );
}
export default SignUpFailed;