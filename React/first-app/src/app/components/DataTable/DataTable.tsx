import {useState} from "react";
import "./DataTable.css"

let people: string[] = ['Apple',
    'Banana',
    'Cherry',
    'Date',
    'Fig',
    'Grape'];


export default function DataTable() {

    const [fruits, setFruits] = useState<string[]>(people);
    const [tempFruit, setTempFruit] = useState('');

    const addFruit = (fruit: string) => {
        setFruits([...fruits, fruit]);
    };


    const submitTableForm = () => {
        addFruit(tempFruit);
    }


    return (
        <div>
            <h1>Fruit List</h1>
            <ul>
                {people.map((fruit, index) => (
                    <li key={index}>{fruit}</li>
                ))}
            </ul>
            <form id="tableForm" onSubmit={
                (e) => {
                    e.preventDefault();
                    submitTableForm();
                }
            }>
                <input onChange={
                    (e: any) => {
                        setTempFruit(e.target.value);
                    }
                } type="text">Add Element</input>
                <button type="submit" id="table-submit-button">Submit</button>
            </form>
        </div>
    );
}