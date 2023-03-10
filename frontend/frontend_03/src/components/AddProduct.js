import axios from 'axios';
import { useState } from 'react';
import { Link, Navigate, useNavigate, useParams } from 'react-router-dom';
// import { useEffect } from 'react/cjs/react.development';
import { useEffect } from 'react';
import productService from '../services/product.service';


const AddProduct = (props) => {
  const [productName, setProductName] = useState('');
  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');
  const [description, setDescription] = useState('');
  const [inStock, setInStock] = useState('');
  

  const navigate = useNavigate();
  const { id } = useParams();

  const saveProduct = (p) => {
    p.preventDefault();

    const product = {
      productName,
      latitude,
      longitude,
      description,
      inStock,
    };
    if (id) {
      //update
      productService
        .update(product)
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
      productService
        .create(product,props.categoryId)
        .then((response) => {
          console.log('employee added successfully', response.data);
        //  history.push('/category');
        //  navigate("/adminproduct");
          props.refreshProducts();
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
      productService
        .get(id)
        .then((category) => {
          setProductName(category.data.firstName);
          setDescription(category.data.lastName);
  
        })
        .catch((error) => {
          console.log('Something went wrong', error);
        });
    }
  }, []);

const backToProducts=()=>{
  props.refreshProducts();
}


  return (
    <div className='container'>
      {/* <div>......</div>
      <div>......</div>
      <div>......</div>
      <div>......</div> */}
      <h3>Add Product</h3>
      <hr />
      <form>
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='productName'
            value={productName}
            onChange={(p) => setProductName(p.target.value)}
            placeholder='Enter category name'
          />
        </div>
        <br></br>

        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='latitude'
            value={latitude}
            onChange={(p) => setLatitude(p.target.value)}
            placeholder='Enter latitude'
          />
        </div>

        <br></br>

        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='longitude'
            value={longitude}
            onChange={(p) => setLongitude(p.target.value)}
            placeholder='Enter longitude'
          />
        </div>

        <br></br>

        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='description'
            value={description}
            onChange={(c) => setDescription(c.target.value)}
            placeholder='Enter description'
          />
        </div>

        <br></br>

        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='instock'
            value={inStock}
            onChange={(c) => setInStock(c.target.value)}
            placeholder='Enter instock'
          />
        </div>

        <br></br>
        
        <div>
          <button onClick={(p) => saveProduct(p)} className='btn btn-primary'>
            Save Or Update
          </button>
          
        </div>

        
       </form>
       <hr />
       <button onClick={(p) => backToProducts(p)} className='btn btn-primary'>
            Back
          </button>
       {/* <Link to='/adminproduct'>Back to List</Link> */}

       
     </div>
  );
};

export default AddProduct;
