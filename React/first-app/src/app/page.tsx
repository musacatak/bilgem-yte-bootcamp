'use client'
import styles from './page.module.css'
import FormElement from './components/FormElement'
import FirstButton from "@/app/components/FirstButton";

import React, {useState} from 'react';

export default function Home() {
    const [name, setName] = useState('');
    const [company, setCompany] = useState('');
    const [address, setAddress] = useState('');

    console.log(name, company, address);


    return (
        <main>
            <FormElement myLabel='Name' inputHandler={setName}/>
            <FormElement myLabel='Company Name' inputHandler={setCompany}/>
            <FormElement myLabel='Address' inputHandler={setAddress}/>
            <FirstButton data={[name, company, address]}/>
        </main>

    )
}
