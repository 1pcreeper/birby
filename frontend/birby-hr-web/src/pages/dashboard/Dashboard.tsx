import Container from "../../components/common/general/Container";
import { Link } from "react-router-dom";
function Dashboard() {
    return (
        <>
            <Container>
                <div className="flex flex-wrap">
                    <details className="border-4 border-b-blue-950 rounded-lg" >
                        <summary className="border-b-4 border-b-blue-950 p-3 text-3xl">
                            Human Resource
                        </summary>
                        <section>
                            <ul className="pl-4 text-2xl">
                                <li>
                                    <Link to="/staffs">
                                        Staff Management
                                    </Link>
                                </li>
                            </ul>
                        </section>
                    </details>
                </div>
            </Container>
        </>
    )
}
export default Dashboard;