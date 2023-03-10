import { Link } from 'react-router-dom';
import { useState } from 'react';
import adminService from '../services/admin.service ';
// import { Navigate } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


const CustomerLoginFailed = (props) => {
 

    return (
        <>
            <div>.....</div>
            <div>.....</div>
            <div>.....</div>
            {/* <div>.....</div> */}
            <h1>Failed to Login </h1>
            <h2>You have enetered incorrect username or password</h2>
                        <br></br> 
        

        <Link to='/customerlogin' className='btn btn-primary mb-2'>
        <h3>click here to login again</h3>
          </Link>

        </>
    );
}
export default CustomerLoginFailed;