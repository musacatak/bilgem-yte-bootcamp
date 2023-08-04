import { useState} from "react";
import { useRouter  } from 'next/navigation';

export default function Garden() {
    const navigation = useRouter ();


    const [garden, setGarden] = useState(Array.from({length: 5}, () =>
        Array.from({length: 5}, () => 'D')));
   const[budget,setBudget] = useState(100);


    const handleChange = (row:number, column:number) => {

        if(budget <= 0){
            alert("Game Over");
            navigation.push('pages/game')
        }

        if(garden[row][column] === 'D'){
            setBudget(budget-5);
            let copy = [...garden];
            copy[row][column] = "T";
            setGarden(copy);
            let counter: number = 0;
            console.log(garden);

            const intervalID = setInterval(() => {

                let copy = [...garden];

                if (copy[row][column] == "T") {
                    copy[row][column] = "F";
                } else if (copy[row][column] == "F") {
                    copy[row][column] = "M";
                } else if (copy[row][column] == "M" && counter < 5) {
                    copy[row][column] = "M";
                    counter +=1;
                } else if (copy[row][column] == "M" && counter >= 5) {
                    copy[row][column] = "Ç";
                }
                console.log(counter)
                setGarden(copy);

            }, 1000)
            return () => clearInterval((intervalID))
        }
        else {

            if (garden[row][column] == "T") {
            } else if (garden[row][column] == "F") {

            } else if (garden[row][column] == "M" ) {
                setBudget(budget + 10);
            } else if (garden[row][column] == "Ç" ) {
               setBudget(budget - 10);

            }
            garden[row][column] = "D";
            setGarden(garden);

        }


    }

    return (
        <div className="sheet">
            <button onClick={() => {navigation.push('./log-in');}} >Log Out</button>
            <h1>{budget}</h1>
            <table>
                <tbody>
                {garden.map((row, rowIndex) => (
                    <tr key={rowIndex}>
                        {row.map((column, columnIndex) => (
                            <td key={columnIndex}>
                                <button
                                    onClick={() => handleChange(rowIndex, columnIndex)}
                                >{garden[rowIndex][columnIndex]}</button>
                            </td>
                        ))}
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}