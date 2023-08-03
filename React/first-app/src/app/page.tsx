'use client'
import FormElement from './components/FormElement'
import FirstButton from "@/app/components/FirstButton";

import "./page.css"

import React, {  useState } from 'react';
import ShowButton from "@/app/components/ShowButton";
//import DataTable from './components/DataTable/DataTable';
import PractiseUseEffect from "@/app/components/PractiseUseEffect/PractiseUseEffect";
import PersonCard from "@/app/components/PersonCard/PersonCard";
import PSetInterval from "@/app/components/PSetInterval/PSetInterval";

export default function Home() {
    const [name, setName] = useState('');
    const [company, setCompany] = useState('');
    const [address, setAddress] = useState('');
    const [show, setShow] = useState(false);



    //console.log(name, company, address);


    return (
        <main className='my-app'>
            <div className='my-form'>
                <FormElement myLabel='Name' inputHandler={setName} />
                <FormElement myLabel='Company Name' inputHandler={setCompany} />
                <FormElement myLabel='Address' inputHandler={setAddress} />
                <FirstButton />
                <ShowButton setShow={setShow} show={show} />

            </div>

            {show ? (
                <PersonCard data={[name,company,address]}/>
            ) : null}

            <div className="table-form">
                {/* <DataTable/> */}
            </div>

            <div  className='person-information'>
               <PractiseUseEffect/>
            </div>

            <div  className='person-information'>
                <PSetInterval/>
            </div>

        </main>

    )
}
