import {Dispatch} from "react"
import "./FormElement.css";

interface propsType {
    myLabel: string,
    inputHandler: Dispatch<string>
}

export default function FormElement(props: propsType) {

    return (
        <div className="input-label">
            <span>{props.myLabel}</span>
            <input type='text' onChange={(e: any) => {
                props.inputHandler(e.target.value);
            }}/>

        </div>
    )
}