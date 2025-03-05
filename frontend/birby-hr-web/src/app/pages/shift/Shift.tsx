import { Link } from "react-router-dom";
import Container from "../../components/common/general/Container";
import TitleHeader from "../../components/common/general/TitleHeader";
import SearchBar from "../../components/common/general/SearchBar";

function Shift() {
    return (
        <>
            <Container>
                <TitleHeader title="Shift Management" />
                <div className="pb-3 gap-x-2 flex">
                    <Link to="/dashboard">
                        <button className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                            Back
                        </button>
                    </Link>
                </div>
                <div className="mb-3">
                    <SearchBar />
                    <div className="flex flex-wrap gap-2">
                        <div>
                            <label htmlFor="form-date-start">Start :</label>
                            <input className="border-1" type="date" name="form-date-start" id="form-date-start" />
                        </div>
                        <div>
                            <label className="ms-3" htmlFor="form-date-start">End :</label>
                            <input className="border-1" type="date" name="form-date-end" id="form-date-end" />
                        </div>
                    </div>
                </div>
                <div className="overflow-x-auto border-3">
                    <table className="w-full">
                        <thead className="sm:text-2xl text-lg">
                            <tr className="border-b-3">
                                <th className="text-start ps-4">
                                    Name
                                </th>
                                <th>
                                    Role
                                </th>
                                <th>
                                    Date1
                                </th>
                                <th>
                                    Date2
                                </th>
                                <th>
                                    Date1
                                </th>
                                <th>
                                    Date2
                                </th>
                                <th>
                                    Date1
                                </th>
                                <th>
                                    Date2
                                </th>
                                <th>
                                    Date1
                                </th>
                                <th>
                                    Date2
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr className="border-b-3 sm:text-2xl text-center">
                                <td className="text-start ps-4">
                                    Lin Chi Kin
                                </td>
                                <td>IT Admin</td>
                                <td>
                                    Morning
                                </td>
                                <td>
                                    Afternoon
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                            </tr>
                            <tr className="border-b-3 sm:text-2xl text-center">
                                <td className="text-start ps-4">
                                    Lin Chi Kin
                                </td>
                                <td>IT Admin</td>
                                <td>
                                    Morning
                                </td>
                                <td>
                                    Afternoon
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                            </tr>
                            <tr className="border-b-3 sm:text-2xl text-center">
                                <td className="text-start ps-4">
                                    Lin Chi Kin
                                </td>
                                <td>IT Admin</td>
                                <td>
                                    Morning
                                </td>
                                <td>
                                    Afternoon
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                                <td>
                                    Date1
                                </td>
                                <td>
                                    Date2
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </Container>
        </>
    );
}
export default Shift;