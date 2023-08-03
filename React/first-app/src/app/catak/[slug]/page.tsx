'use client'
import React from 'react';
import "./page.css"

interface paramsType{
    params : {slug : string},
}
export default function Cihangir({params} : paramsType){

    const {slug} = params;
    return (

            <main>
                <h1>{slug}</h1>
                <p>This is {slug}'s page content.</p>
                {slug}
            </main>
    );
};
