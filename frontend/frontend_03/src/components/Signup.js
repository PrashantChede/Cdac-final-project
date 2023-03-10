import axios from 'axios';
import { useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
// import { useEffect } from 'react/cjs/react.development';
import { useEffect } from 'react';
import customerService from '../services/customer.service';



const Signup = (props) => {



    const navigate=useNavigate();
    // const { id } = useParams();
    let [custOb,setCustOb]=useState({firstName:"",lastName:"",email:"",
                                    mobNo:"",password:"",cardNumber:"",
                                    location:"",dob:""});


const handleChange=(event)=>{
    // console.log("in handle change");
    const {name,value} =event.target
    setCustOb({...custOb,[name]:value});
}



const registerCustomer = () => {
    console.log("inside registerCustomer");
  //  c.preventDefault();

//     const custOb = {
//         firstName,
//       lastName,
//       email,
//     mobNo,
//     password,
//     cardNumber,
//     location,
//     dob,
//  };
    // if (id) {
    //   //update
    //   customerService
    //     .update(custOb)
    //     .then((response) => {
    //       console.log('Employee data updated successfully', response.data);
    //       // history.push('/');
    //     })
    //     .catch((error) => {
    //       alert(error.response.status);
    //       console.log('Error code ' + error);
    //       console.log('Something went wrong', error.response.data);
    //     });
    // } else {
      //create
      customerService
        .create(custOb)
        .then((response) => {
            console.log("customer object before signing in "+custOb.dob+" "+custOb.dob+"  "+custOb.location);
          console.log('customer added successfully', response.data);
        //  history.push('/category');
        window.alert("you have registered successfully !!");
          navigate("/customerlogin");
          // <Link to='/category'>Back to List</Link>
        })
        .catch((error) => {
          console.log('something went wroing' + error.response);
          navigate("/signupfailed");
        });
   // }
  };




// function registerCustomer(){

// console.log("inside registerCustomer");

// }





    return (
        <>

            {/* <div id="signupContainer">
                <form action="" class="signup-form">
                    <p>Register Yourself</p>
                    <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">First Name</label>
                            <input type="text" name="firstName" placeholder="Alex" required />
                        </div>
                    </div> */}

                    {/* <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">Last Name</label>
                            <input type="text" name="lastName" placeholder="Grey" required />
                        </div>
                    </div> */}

                    {/* <div class="row">
                        <div class="sub-row" id="wide">
                            <label for="">Email</label>
                            <input type="email" name="email" placeholder="alex@gmail.com" required />
                        </div>
                    </div> */}



                    {/* <div class="row"> */}
                        {/* <div class="sub-row">
                            <label for="">Email</label>
                            <input type="text" name="ename" id="" placeholder="enter email" required />
                        </div> */}

                        {/* <div class="sub-row">
                            <label for="">Mobile</label>
                            <input type="number" name="mobNo" id="" placeholder="+00 000 000 0000" required />
                        </div>

                        <div class="sub-row">
                            <label for="">Password</label>
                            <input type="password" name="pass" id="" placeholder="*******" required />
                        </div>
                    </div> */}
                    
                    {/* <div class="row">
                        
                        <div class="sub-row">
                            <label for="">Gender</label>
                            <div class="radio">
                                <input type="radio" name="gender" id="" />
                                <label for="">Male</label>
                                <input type="radio" name="gender" id="" />
                                <label for="">Female</label>
                            </div>
                        </div>
                    </div> */}
                    {/* <div class="row">

                         <div class="sub-row">
                            <label for="">CardNumber</label>
                            <input type="text" name="cardNumber" id="" placeholder="enter adhar card number" required />
                        </div>

                        <div class="sub-row">
                            <label for="">Location</label>
                            <input type="text" name="location" id="" placeholder="enter location " required />
                        </div> 


                        <div class="sub-row">
                            <label for="">Date of birth</label>
                            <input type="date" name="dob" id="" required /></div>
                        <div class="sub-row">
                            
                        </div>
                    </div>
                    <div class="row submit">
                        <input type="submit" value="Register" id="submit" />
                    </div>
                    <Link to="/login" class="loginInsted">Login Instead?</Link>
                </form>
            </div> */}




                {/* my implementation */}


                <div id="loginContainer">
                <form class="login-form" >
                    <div class="title">
                        <p>Register New Customer</p>
                    </div>
                    {/* <div class="username">
                        <input type="text" name="email" id="email" placeholder="Email" required />
                    </div>
                    <div class="pass">
                        <input type="password" name="pass" id="pass" placeholder="Password" required />
                    </div> */}


                    <div class="form-group">
                <input type="text" class="form-control" id="firstName" name="firstName" 
                value={custOb.firstName} 
                onChange={handleChange}
                placeholder="enter firstName"/>
            </div>


            <div class="form-group">
                <input type="text" class="form-control" id="lastName" name="lastName" 
                value={custOb.lastName} 
                onChange={handleChange}
                placeholder="enter lastName"/>
            </div>

            <div class="form-group">
                <input type="text" class="form-control" id="email" name="email" 
                value={custOb.email} 
                onChange={handleChange}
                placeholder="enter email"/>
            </div>


            <div class="form-group">
                <input type="text" class="form-control" id="mobNo" name="mobNo" 
                value={custOb.mobNo} 
                onChange={handleChange}
                placeholder="enter mobNo"/>
            </div>



            <div class="form-group">
                <input type="text" class="form-control" id="password" name="password" 
                value={custOb.password} 
                onChange={handleChange}
                placeholder="enter password"/>
            </div>


            <div class="form-group">
                <input type="text" class="form-control" id="cardNumber" name="cardNumber" 
                value={custOb.cardNumber} 
                onChange={handleChange}
                placeholder="enter cardNumber"/>
            </div>

            <div class="form-group">
                <input type="text" class="form-control" id="location" name="location" 
                value={custOb.location} 
                onChange={handleChange}
                placeholder="enter location"/>
            </div>


            <div class="form-group">
                <input type="date" class="form-control" id="dob" name="dob" 
                value={custOb.dob} 
                onChange={handleChange}
                placeholder="enter dob"/>
            </div>


           





                    
                    <div class="remember-me">
                        <input type="checkbox" name="remember" id="checkbox" />
                        <label for="checkbox">Remember Me</label>
                    </div>
                   
                    {/* <div class="forgot-pass">
                        <Link to="/">Forgot Password?</Link>
                    </div> */}


                    {/* <div class="forgot-pass">
                        <Link to="/forgotPassword">Forgot Password?</Link>
                    </div> */}

                    <div class="login-button">
                        <input id="submit" type="button" value="Register"  onClick={()=>registerCustomer()} required/>
                    </div>

                    {/* <div class="signup-link">
                        <Link to="/signup">Signup for New Account Here</Link>
                    </div> */}
                    
                     {/* <div class="row submit">
                        <input type="submit" value="Register" id="submit" />
                    </div> */}

                    {/* <Link to="/login" class="loginInsted">Login as admin Instead?</Link> */}

                    <Link to="/adminlogin" class="loginInsted">Login as admin Instead?</Link>
                    <Link to="/customerlogin" class="loginInsted">Login as customer Instead?</Link>

                </form>
            </div>








        </>
    );
}
export default Signup;