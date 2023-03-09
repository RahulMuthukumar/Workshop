import axios from "axios";
import React from "react"
import './form.css';
import { useState, useEffect } from "react";

export default function Table1() {
  const [data, setData] = useState([]);
  const [id, setId] = useState('');
  const [playerName, setPlayerName] = useState('');
  const [clubName, setClubName] = useState('');
  const [age, setAge] = useState('');
  const [position, setPosition] = useState('');

  function init() {
    axios
      .get("http://localhost:8080/getPlayer")
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  const deleteData = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/DelPlayer/${id}`);
      setData(data.filter((item) => item.id !== id));
    } catch (error) {
      console.log(error);
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const playerData = {
      id,
      name: playerName,
      club: clubName,
      age,
      pos: position,
    };
    console.log(playerData)
    axios.put('http://localhost:8080/update/'+id, playerData);
    window.location.reload();
  };
  useEffect(() => {
    init();
  }, []);

  return (
    <div>
    <table border={1}>
      <thead>
        <tr>
          <th>ID</th>
          <th>Player Name</th>
          <th>Club Name</th>
          <th>Age</th>
          <th>Position</th>
        </tr>
      </thead>
      <tbody>
        {data.map((user) => (
          <tr key={user.id}>
            <td>{user.id}</td>
            <td>{user.name}</td>
            <td>{user.club}</td>
            <td>{user.age}</td>
            <td>{user.pos}</td>
            <button
            className="btn btn-primary"
            onClick={() => deleteData(user.id)}
            >
            Delete
            </button>
          </tr>
        ))}
      </tbody>
    </table>

    <form onSubmit={handleSubmit}>
      <h2>Football Player Stats</h2>
      <input
        placeholder='ID'
        type="text"
        name="id"
        value={id}
        onChange={(event) => setId(event.target.value)}
      />
      <input
        placeholder='Player Name'
        type="text"
        name="playerName"
        value={playerName}
        onChange={(event) => setPlayerName(event.target.value)}
      />
      <input
        placeholder='Club Name'
        type="text"
        name="clubName"
        value={clubName}
        onChange={(event) => setClubName(event.target.value)}
      />
      <input
        placeholder='Age'
        type="text"
        name="age"
        value={age}
        onChange={(event) => setAge(event.target.value)}
      />
      <input
        placeholder='Position'
        type="text"
        name="position"
        value={position}
        onChange={(event) => setPosition(event.target.value)}
      />

      <button>update</button>
    </form>
    </div>
  );
}
