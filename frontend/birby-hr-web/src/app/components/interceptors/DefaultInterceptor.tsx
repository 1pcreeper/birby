import { Outlet } from "react-router-dom";

function DefaultInterceptor() {
    return (
        <>
            <Outlet />
        </>
    );
}
export default DefaultInterceptor;