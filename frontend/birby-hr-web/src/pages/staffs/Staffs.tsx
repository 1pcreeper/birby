import { Link } from "react-router-dom";
import Container from "../../components/common/general/Container";
import TitleHeader from "../../components/common/general/TitleHeader";
function Staffs() {
    return (
        <>
            <Container>
                <TitleHeader title="Staff Management" />
                <div className="flex justify-around rounded-2xl border-2 mb-5">
                    <input type="text" className="w-full py-2" />
                    <button className="text-white border-l-2 px-5 rounded-r-2xl dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                        Search
                    </button>
                </div>
                <div className="overflow-x-auto border-3">
                    <table className="w-full">
                        <thead className="sm:text-2xl text-lg">
                            <tr className="border-b-3">
                                <th className="text-start ps-4">
                                    Name
                                </th>
                                <th>
                                    Tag
                                </th>
                                <th>
                                    Roles
                                </th>
                                <th>
                                    Control
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr className="border-b-3 sm:text-2xl text-center">
                                <td className="text-start ps-4">Lin Chi Kin</td>
                                <td>A1234</td>
                                <td>IT Admin</td>
                                <td>
                                    <Link to="/staffs/view/1212" className="text-white bg-blue-400 px-4 rounded-xl">
                                        Edit
                                    </Link>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </Container>
        </>
    );
}
export default Staffs;