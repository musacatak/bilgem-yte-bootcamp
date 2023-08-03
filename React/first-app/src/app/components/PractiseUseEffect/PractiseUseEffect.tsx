import React, {useEffect, useState} from "react";

export default function PractiseUseEffect() {

    const serverUrl = 'https://jsonplaceholder.typicode.com/todos/1';
    const [title, setTitle] = useState<string>('');

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(serverUrl);
                const data = await response.json();
                setTitle(data.title);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <>
            <h1>Fetched Title:</h1>
            <p>{title}</p>
        </>
    )
}