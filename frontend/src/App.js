import React, { useState, useEffect } from "react";
import logo from "./logo.svg";
import "./App.css";

// 백엔드 서버와 비동기 통신을 하기 위한 axios 라이브러리를 가져옵니다.
import axios from "axios";

function App() {
  // DB에 저장된 값을 가져와서 화면에 보여주기 전에 이 lists State에 넣어줍니다.
  const [lists, setLists] = useState([]);
  // Input 박스에 입력한 값이 이 value State에 들어갑니다.
  const [value, setValue] = useState("");

  useEffect(() => {
    // 여기서 데이터베이스에 있는 값을 가져옵니다.
    axios.get("/api/values").then((response) => {
      console.log("response", response);
      setLists(response.data);
    });
  }, []);

  // Input 박스에 값을 입력(onChange 이벤트가 발생)할 때 마다 value State를 변경합니다.
  const changeHandler = (event) => {
    setValue(event.currentTarget.value);
  };

  // Input 박스에 값을 입력하고 확인 버튼을 누르면
  // 입력한 값이 데이터베이스에 저장되고 화면에 값을 보여줍니다.
  const submitHandler = (event) => {
    event.preventDefault();

    axios.post("/api/values", { value: value }).then((response) => {
      if (response.data.success) {
        console.log("response", response);
        setLists([...lists, response.data]);
        setValue("");
      } else {
        alert("DB에 값을 넣는데 실패했습니다.");
      }
    });
  };

  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="container">
            {lists &&
                lists.map((list, index) => <li key={index}>{list.value} </li>)}
            <br />
            <form className="example" onSubmit={submitHandler}>
              <input
                  type="text"
                  placeholder="입력해주세요..."
                  onChange={changeHandler}
                  value={value}
              />
              <button type="submit">확인</button>
            </form>
          </div>
        </header>
      </div>
  );
}

export default App;