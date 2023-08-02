import {ChangeEvent, SetStateAction, useState, Dispatch} from "react"
import "./FormElement.css";
import {Simulate} from "react-dom/test-utils";
import input = Simulate.input;

interface propsType {
    myLabel: string,
    inputHandler: Dispatch<string>
}

export default function FormElement(props: propsType) {

    return (
        <div className="inputLabel">
            <span>{props.myLabel}</span>
            <input type='text' onChange={(e: any) => {
                props.inputHandler(e.target.value);
            }}/>

        </div>
    )
}