'use client'
import FormElement from './components/FormElement'
import FirstButton from "@/app/components/FirstButton";
import "./page.css"

import React, {useState} from 'react';
import ShowButton from "@/app/components/ShowButton";

export default function Home() {
    const [name, setName] = useState('');
    const [company, setCompany] = useState('');
    const [address, setAddress] = useState('');
    const [show, setShow] = useState(false);

    //console.log(name, company, address);


    return (
        <main className='my-app'>
            <div className='my-form'>
                <FormElement myLabel='Name' inputHandler={setName}/>
                <FormElement myLabel='Company Name' inputHandler={setCompany}/>
                <FormElement myLabel='Address' inputHandler={setAddress}/>
                <FirstButton data={[name, company, address]} />
                <ShowButton setShow = {setShow} show={show} />

            </div>

            {show ? (
                <div className='person-information'>
                    <h1>Person Information:</h1>
                    <br/>
                    <h2>Name: {name}</h2>
                    <br/>
                    <h2>Company: {company}</h2>
                    <br/>
                    <h2>Address: {address}</h2>

                </div>
            ) : null}



        </main>

    )
}
