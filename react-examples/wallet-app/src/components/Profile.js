import { Link, Routes, Route, useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";

// component to addContact
export function AddContacts() {
    let {emailId} = useParams();
    
    
    return (<div className = 'container'>
        <h3>Add contact to your wallet</h3>
       
        
    </div>)
}

// component to success
export function ProfileSuccess() {
    let {emailId} = useParams(); // extracts :emailId from the path parameter
    let [profile, setProfile] = useState({});
    let url = `http://localhost:9090/api/profile/${emailId}`;
    
    useEffect(() => {
        axios.get(url).then(response => setProfile(response.data))
    });

    return (<div className = 'container row' >
        <div className = 'col-4'>
            <img src = "data:image/png;base64,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" className= 'roundImage' width = '100' height = '100'></img>
            <p>Name: {profile.name}</p>
            <p>Birthday: {profile.dob}</p>
            <p>Phone: {profile.phone}</p>
        </div>
        <div className = 'col-6'>
            <Link to = 'dashboard'>Dashboard</Link> | 
            <Link to = 'addContacts'>Add Contacts</Link> |
            <Link to = 'viewContacts'>View Contacts</Link> |
            <Link to = 'wallet'>Wallet</Link>
            <div>
                <Routes>
                    <Route path = '' element = {<div>Welcome, {emailId}</div>}></Route>
                    <Route path = 'dashboard' element = {<div>Welcome, {emailId}</div>} />
                    <Route path = 'addContacts' element = {<AddContacts />} />
                    <Route path = 'viewContacts' element = {<div>Welcome, {emailId}, your can view Contacts</div>}></Route>
                    <Route path = 'wallet' element = {<div>Welcome, {emailId}, this is your wallet</div> }></Route>
                </Routes>
            </div>
        </div>
    </div>);
}


// component to register
export function ProfileRegistration() {
    // profile needs name, emailId, password, phone, dob
    let [emailId, setEmailId] = useState('');
    let [name, setName] = useState('');
    let [password, setPassword] = useState('');
    let [dob, setDob] = useState('');
    let [phone, setPhone] = useState('');

    let navigate = useNavigate(); 
    let handleSubmit = (e) => {
        e.preventDefault();
        // once the data goes the backend you need to navigate to the login
        let profile = {"name":name, "emailId": emailId, "password": password, "dob":dob, "phone":phone};
        let url = 'http://localhost:9090/api/profile';
        axios.post(url, profile)
        .then( response => navigate('/login') )
        .catch(err => navigate('/register'));
        
    }
    return (<div className = 'container'>
        <h3>Registration Form</h3> <hr />
        <form onSubmit = {handleSubmit}>
            <div className = 'w-25'>
                Enter Name
                <input type = 'text' className = 'form-control' onChange = {e => setName(e.target.value)}></input>
            </div>
            <div className = 'w-25'>
                <label>Enter Email Id</label>
                <input type = 'email' className = 'form-control'  onChange = {e => setEmailId(e.target.value)}></input>
            </div>
            <div className = 'w-25'>
                <label>Enter Password</label>
                <input type = 'password' className = 'form-control'  onChange = {e => setPassword(e.target.value)}></input>
            </div>
            <div className = 'w-25'>
                <label>Select Birthday</label>
                <input type = 'date' className = 'form-control'  onChange = {e => setDob(e.target.value)}></input>
            </div>
            <div className = 'w-25'>
                <label>Enter Mobile No.</label>
                <input type = 'number' className = 'form-control'  onChange = {e => setPhone(e.target.value)}></input>
            </div>
            <br />
            <div className = 'w-25'>
                <input type = 'submit' value = 'Register' className= 'btn btn-secondary'></input>
            </div>
        </form>
        <div>
            <Link to = '/login'>Login</Link>
        </div>
    </div>)
}

// component to login
export function ProfileLogin() {
    let [emailId, setEmailId] = useState('');
    let [password, setPassword] = useState('');
    let [loginError, setLoginError] = useState('');
    // to programmatically navigate
    let navigate = useNavigate();
    //authenticate the emailId and password
    let handleSubmit = (e) => { 
        e.preventDefault();
        let url = `http://localhost:9090/api/profile/${emailId}/${password}`;
        axios.get(url)
        .then(response => {
            navigate('/success/'+emailId);
        })
        .catch(err => {
            navigate('/login');
            setLoginError('Username or Password is wrong');
            setEmailId('');
            setPassword('');
        })
        
    };
    return (<div className = 'container'>
        <h3>Login Form</h3> <hr />
        <form onSubmit={handleSubmit}>
            <div className = 'text-danger'>
                {loginError}
            </div>
            <div className="w-25">
                <input type = 'text' placeholder= 'Enter your email' 
                    className = 'form-control'  value = {emailId}
                    onChange = {e => setEmailId(e.target.value)}></input>
            </div>
            <div className="w-25">
                <input type = 'password' placeholder= 'Enter your password' 
                    className = 'form-control' value = {password}
                    onChange = {e => setPassword(e.target.value)}></input>
            </div>
            <div>
                <input type = 'submit' className = 'btn btn-secondary' value = 'Login'></input>
            </div>
        </form>
        <div>
            <Link to = '/register'>Create Profile</Link>
        </div>
    </div>)
}