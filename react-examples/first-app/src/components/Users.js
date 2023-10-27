import { useState } from "react";

export function UserForm() {
    let [name, setName] = useState('');
    let [phone, setPhone] = useState('');

    // prevents the default form submission behaviour
    let handleClick = (e) => {e.preventDefault(); setName(''); setPhone('')};

    return (<div className="w-25">
        <h3>Hello {name}, Phone = {phone}</h3>
        <form onSubmit = {handleClick}>
            <div>
                <input type='text' onChange = {(e)=>setName(e.target.value)} value = {name}
                    className="form-control" placeholder="Enter name"></input>
            </div>
            <div>
                <input type='number' onChange={(e)=>setPhone(e.target.value)} value = {phone}
                 className="form-control" placeholder="Enter phone no."></input>
            </div>
            <div>
                <input type="submit" value="Register" className="btn btn-primary"></input>
            </div>
        </form>
        
    </div>);
}