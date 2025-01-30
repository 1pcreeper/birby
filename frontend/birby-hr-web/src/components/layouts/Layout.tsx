import { Outlet } from "react-router-dom";
import Header from "./Header";
import Main from "./Main";
import Footer from "./Footer";

function Layout() {
    return (
        <>
            <Header />
            <Main>
                <Outlet />
            </Main>
            <Outlet />
            <Footer />
        </>
    );
}
export default Layout;