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
import {ThemeContext} from "@/app/components/ThemeContext/ThemeContext";
import ContextExample from "@/app/components/ThemeContext/ContextExample";
import ChildrenExample from "@/app/components/ChildrenExample/ChildrenExample";

export default function Home() {
    const [name, setName] = useState('');
    const [company, setCompany] = useState('');
    const [address, setAddress] = useState('');
    const [show, setShow] = useState(false);



    //console.log(name, company, address);


    return (

        <>
            <header>
                <nav>
                    <a href="/">Home</a>
                    <a href="/catak/Cihangir">Cihangir Page</a>
                    <a href="/catak/Musa">Musa Page</a>
                </nav>
            </header>

            <main className='my-app'>

                <ThemeContext.Provider value={"light"}>


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

                    <ChildrenExample label={"Hello World!"} >
                        <p>Ben cocukum</p>
                    </ChildrenExample>

                    <ContextExample />

                </ThemeContext.Provider>


            </main>
        </>



    )
}
