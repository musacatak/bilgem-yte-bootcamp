import React from "react";
import "./PersonCard.css"

interface propsType{
    data : string[],
}
export default function PersonCard(props : propsType){



    return(
        <div className='person-information'>
            <h1>Person Information:</h1>
            <br />
            <h2>Name: {props.data[0]}</h2>
            <br />
            <h2>Company: {props.data[1]}</h2>
            <br />
            <h2>Address: {props.data[2]}</h2>
        </div>
    )
}