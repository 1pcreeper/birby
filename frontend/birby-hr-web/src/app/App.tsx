import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import './App.css'

function App() {
  const router = createBrowserRouter([]);
  return (
    <>
      <RouterProvider router={router}></RouterProvider>
    </>
  )
}

export default App
