import { useState } from 'react';
import axios from 'axios';
import './form.css';

function PlayerForm() {
  const [id, setId] = useState('');
  const [playerName, setPlayerName] = useState('');
  const [clubName, setClubName] = useState('');
  const [age, setAge] = useState('');
  const [position, setPosition] = useState('');

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
    axios.post('http://localhost:8080/addPlayer', playerData)
    //   .then((response) => {
    //     console.log(response);
    //   })
    //   .catch((error) => {
    //     console.log(error);
    //   });
  };

  return (
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

      <button>Submit</button>
    </form>
  );
}

export default PlayerForm;
